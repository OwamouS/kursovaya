package com.ifmo.isdb.DB.repos;

import com.ifmo.isdb.DB.pojo.High_CouncilMember;
import com.ifmo.isdb.DB.pojo.High_CouncilMemberKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface HighCouncilMembersRepo extends JpaRepository<High_CouncilMember, Integer> {
    @Query(value = "SELECT high_council_id from high_council_members where member_id = :id", nativeQuery = true)
    Integer getMember(Integer id);
    @Modifying
    @Query(value = "INSERT into high_council_members (high_council_id, member_id, member_mode) VALUES (:high_id,:member_id,:member_mode)", nativeQuery = true)
    Integer addMember(Integer high_id, Integer member_id, Integer member_mode);
}
