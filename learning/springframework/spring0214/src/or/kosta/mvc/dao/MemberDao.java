package or.kosta.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.kosta.vo.MemberVO;

@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	public void addMember(MemberVO vo){
		ss.insert("member.add", vo);
	}
	public List<MemberVO> getList(){
		return ss.selectList("member.list");
	}
	public MemberVO getDetail(int num){
		return ss.selectOne("member.detail",num);
	}
}




