package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.app.domain.Member;

@Mapper
public interface MemberMapper {

	@Select("SELECT * FROM members")
	List<Member> findAll();

	@Select("SELECT * FROM members WHERE id = #{id}")
	Member findById(int id);
}
