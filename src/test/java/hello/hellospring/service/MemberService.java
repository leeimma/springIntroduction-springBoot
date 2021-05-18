package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
    * 회원가입
    */
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원x
        memberRepository.findByName(member.getName())
                .ifPresent(member1 -> {
//                    throw new IllegalAccessException("이미 존재하는 회원입니다.");
                });

        memberRepository.save(member);
        return member.getId();
    }


}
