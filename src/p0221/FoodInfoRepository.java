package p0221;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import p0219.DBcon;

public class FoodInfoRepository {

	public List<FoodInfoVO> selectFoodInfoList(FoodInfoVO foodInfo){
		List<FoodInfoVO> foodInfoList = new ArrayList<>();
		String sql = "SELECT FI_NUM, FI_NAME, FI_PRICE FROM FOOD_INFO WHERE 1=1";
		if(foodInfo !=null) {
			if(foodInfo.getFiName()!=null) {
				sql+= " AND FI_NAME LIKE CONCAT('%',?,'%')";
			}
			if(foodInfo.getFiPrice()!=0) {
				sql+= " AND FI_PRICE = ?";
			}
		}
		System.out.println(sql);
		System.out.println();
		try(Connection con = DBcon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);){
			if(foodInfo !=null) {
				if(foodInfo.getFiName() !=null) {
					ps.setString(1, foodInfo.getFiName());
				}
				if(foodInfo.getFiPrice()!=0) {
					if(foodInfo.getFiName() !=null){
						ps.setInt(2, foodInfo.getFiPrice());
					}else {
						ps.setInt(1, foodInfo.getFiPrice());
					}
				}
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				FoodInfoVO food = new FoodInfoVO();
				food.setFiNum(rs.getInt("FI_NUM"));
				food.setFiName(rs.getString("FI_NAME"));
				food.setFiPrice(rs.getInt("FI_PRICE"));
				foodInfoList.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foodInfoList;
	}
	
	public FoodInfoVO selectFoodInfo(int fiNum) {
		String sql = "SELECT FI_NUM, FI_NAME, FI_PRICE FROM FOOD_INFO WHERE FI_NUM=?";
		System.out.println(sql);
		System.out.println();
		try(Connection con = DBcon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, fiNum);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				FoodInfoVO food = new FoodInfoVO();
				food.setFiNum(rs.getInt("FI_NUM"));
				food.setFiName(rs.getString("FI_NAME"));
				food.setFiPrice(rs.getInt("FI_PRICE"));
				return food;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int updateFoodInfo(FoodInfoVO foodInfo) {
		String sql = "UPDATE FOOD_INFO SET FI_NAME=?,FI_PRICE=? WHERE FI_NUM=?";
		try(Connection con = DBcon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, foodInfo.getFiName());
			ps.setInt(2, foodInfo.getFiPrice());
			ps.setInt(3, foodInfo.getFiNum());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteFoodInfo(int fiNum) {
		String sql = "DELETE FROM FOOD_INFO WHERE FI_NUM=?";
		try(Connection con = DBcon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, fiNum);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int insertFoodInfo(FoodInfoVO foodInfo) {
		String sql = "INSERT INTO FOOD_INFO(FI_NAME, FI_PRICE) VALUES(?,?)";
		try(Connection con = DBcon.getCon();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, foodInfo.getFiName());
			ps.setInt(2, foodInfo.getFiPrice());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		FoodInfoRepository fiRepo = new FoodInfoRepository();
		FoodInfoVO foodInfo = new FoodInfoVO();
		//foodInfo.setFiName("김");
		foodInfo.setFiPrice(2000);
		List<FoodInfoVO> foodInfoList = fiRepo.selectFoodInfoList(foodInfo);
		for(FoodInfoVO food : foodInfoList) {
			System.out.println(food);
			int result = fiRepo.deleteFoodInfo(1);
			System.out.println(result);
			
			foodInfo = new FoodInfoVO();
			foodInfo.setFiName("쭈꾸미");
			foodInfo.setFiPrice(35000);
			foodInfo.setFiNum(11);
			result = fiRepo.updateFoodInfo(foodInfo);
			System.out.println(result);
		}
	}
}
