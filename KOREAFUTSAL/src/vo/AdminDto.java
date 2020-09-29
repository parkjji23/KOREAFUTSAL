package vo;

public class AdminDto {
	
	String admin_id; //아이디
	String admin_password; //비밀번호
	String admin_name; //사용자이름
	String admin_Number; //식별번호 (사번)
	String position; //직급
	
	
	
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_Number() {
		return admin_Number;
	}
	public void setAdmin_Number(String admin_Number) {
		this.admin_Number = admin_Number;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	

}
