package p0224;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class UserInfoRepository {

	public List<Map<String,String>> selectUserInfos(Map<String,String> param){
		try(SqlSession session = MybatisConfig.getSSF().openSession();){
			return session.selectList("p0224.UserInfoMapper.selectUserInfos",param);
		}
	}
	
	public Map<String,String> selectUserInfo(int uiNum){
		try(SqlSession session = MybatisConfig.getSSF().openSession()){
		return session.selectOne("p0224.UserInfoMapper.selectUserInfo",uiNum);
		}
	}
	public int insertUserInfo(Map<String,String> param){
		try (SqlSession session = MybatisConfig.getSSF().openSession(true);){
			return session.insert("p0224.UserInfoMapper.insertUserInfo",param);
		}
	}
		
	public int updateUserInfo(Map<String,String> param){
		try (SqlSession session = MybatisConfig.getSSF().openSession(true);){
			return session.update("p0224.UserInfoMapper.updateUserInfo",param);
		}
	}
	
	public int deleteUserInfo(int uiNum) {
		try(SqlSession session = MybatisConfig.getSSF().openSession(true);){
			return session.delete("p0224.UserInfoMapper.deleteUserInfo",uiNum);
		}
	}
	public static void main(String[] args) {
		UserInfoRepository uiRepo = new UserInfoRepository();
		List<Map<String,String>> userInfos = uiRepo.selectUserInfos(null);
		for(Map<String,String> userInfo : userInfos) {
			System.out.println(userInfo);
		}
		
		Map<String, String> param = new HashMap<>();
		param.put("uiName", "박지성");
		param.put("uiId", "park");
		param.put("uiPwd", "pass");
		int result = uiRepo.insertUserInfo(param);
		System.out.println("입력 갯수 :" + result);
		
		param.put("uiNum", "8");
		result = uiRepo.updateUserInfo(param);
		System.out.println("수정 갯수:" + result);
		
		result = uiRepo.deleteUserInfo(11);
		System.out.println("삭제 갯수:" + result);
	}
}
