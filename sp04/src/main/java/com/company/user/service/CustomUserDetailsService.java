package com.company.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.company.user.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component("customUserDetailService")
public class CustomUserDetailsService implements UserDetailsService {

	@Setter(onMethod_ = { @Autowired })
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		log.info("Load User By UserName : " + userName);

		MemberVO member = memberMapper.read(userName);

		log.info("queried by member mapper: " + member);

		List<SimpleGrantedAuthority> list = new ArrayList<>();
		
//		member.getAuthList().forEach(auth -> {
//			list.add(new SimpleGrantedAuthority(auth.getAuth()));
//		});

		member.getAuthList().stream().forEach(auth -> list.add(new SimpleGrantedAuthority(auth.getAuth())));

		log.info("member auth list : " + list);
		
		return member == null ? null: new CustomUser(member);
	}

}
