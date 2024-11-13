package helllo.hello_spring.service;

import helllo.hello_spring.domain.Member;
import helllo.hello_spring.repository.MemberRepository;
import helllo.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*회원가입*/
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원x
        validateDuplicateMember(member);//중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*전체 회원 조회*/
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /*특정회원 조회 메서드*/
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}