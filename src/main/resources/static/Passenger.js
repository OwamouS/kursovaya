function sentPassengerApplication(){
    let PassengerApplication = document.getElementById("PassengerApplication").value;
    let st = 'wait';
    fetch("/sentPassengerApplication", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id:0,
            text: PassengerApplication,
            status: st,
            result: null
        })
    });
}
function getPassengerApplications(){
    fetch("/getPassengerApplications")
        .then(res => res.json())
        .then(
            (result) => {
                createApplicationsForm(result);
            }
        )
}
window.onload=function () {
    getPassengerApplications();
    let promise = fetch("/getNotifications", { method : 'GET'}).
    then(response => {
        return response.json();
    }).then((data) =>{
        createNotificationsForm(data);
    });
}
function createNotificationsForm(data) {
    let notificationsForm = document.getElementById("notificationsForm");
    for(let i = 0; i < data.length; i++){

        let notification = document.createElement("div");
        notification.innerText = data[i].text;
        notificationsForm.append(notification);

    }
}
function createApplicationsForm(data) {
    let applicationForm = document.getElementById("applications");
    while (applicationForm.firstChild){
        applicationForm.removeChild(applicationForm.firstChild);
    }
    for(let i = 0; i < data.length; i++){
        let application = document.createElement("div");
        application.className = "app";
        let applicationText = document.createElement("div");
        let applicationStatus = document.createElement("div");
        let applicationAnswer = document.createElement("div");
        applicationText.innerText = data[i].text;
        applicationText.className = "text";
        applicationStatus.innerText = data[i].status;
        applicationAnswer.innerText = data[i].result;
        application.append(applicationText,applicationStatus, applicationAnswer);
        applicationForm.append(application);
    }
}
