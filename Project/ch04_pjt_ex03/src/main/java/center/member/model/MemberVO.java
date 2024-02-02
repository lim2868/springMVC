package center.member.model;

public class MemberVO {
	private String mId;
	private String mPw;
	private String mTel;
	private String mMail;
	private String mRD;
	private String mMD;
	public MemberVO(String mId, String mPw, String mTel, String mMail, String mRD, String mMD) {
		super();
		this.mId = mId;
		this.mPw = mPw;
		this.mTel = mTel;
		this.mMail = mMail;
		this.mRD = mRD;
		this.mMD = mMD;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmTel() {
		return mTel;
	}
	public void setmTel(String mTel) {
		this.mTel = mTel;
	}
	public String getmMail() {
		return mMail;
	}
	public void setmMail(String mMail) {
		this.mMail = mMail;
	}
	public String getmRD() {
		return mRD;
	}
	public void setmRD(String mRD) {
		this.mRD = mRD;
	}
	public String getmMD() {
		return mMD;
	}
	public void setmMD(String mMD) {
		this.mMD = mMD;
	}
	
	
	
}
