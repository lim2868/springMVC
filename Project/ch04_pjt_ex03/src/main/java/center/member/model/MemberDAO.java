package center.member.model;

import java.util.HashMap;
import java.util.Map;

public class MemberDAO {
	private Map<String, MemberVO> memberDB = new HashMap<>();
	
	public void insert(MemberVO m) {
		memberDB.put(m.getmId(), m);
	}
	public MemberVO select(String mId) {
		return memberDB.get(mId);
	}
	public void update(MemberVO m) {
		memberDB.put(m.getmId(), m);
	}
	public void delete(String mId) {
		memberDB.remove(mId);
	}
	public Map<String, MemberVO> getMemberDB() {
		return memberDB;
	}
}
