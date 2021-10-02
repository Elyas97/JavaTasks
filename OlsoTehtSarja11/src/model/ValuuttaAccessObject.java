package model;

/**
 * @author Elyas
 */
import java.sql.*;
import java.util.ArrayList;
public class ValuuttaAccessObject implements IValuuttaDAO {
	Connection conn;
	
	final String URL = "jdbc:mariadb://localhost/valuutta";
	final String USERNAME="root";
	final String PWD="123456Ss";
	Valuutta valuutat[];
	public ValuuttaAccessObject() {
		try {
			conn=DriverManager.getConnection(URL +"?user=" + USERNAME + "&password="+PWD);
		}catch(SQLException e) {
			do {
				System.out.println("Viesti: " + e.getMessage());
				System.out.println("Virhekoodi: " + e.getErrorCode());
				System.out.println("Viesti: " + e.getSQLState());
			}while(e.getNextException()!=null);
			System.exit(-1);
		};
	}
	@Override
	public boolean createValuutta(Valuutta valuutta) {
		boolean temp=false;
		try(PreparedStatement luoTieto= conn.prepareStatement("INSERT INTO valuutat VALUES (?,?,?)"))
		{
			luoTieto.setString(1, valuutta.getTunnus());
			luoTieto.setDouble(2, valuutta.getVaihtokurssi());
			luoTieto.setString(3, valuutta.getNimi());
			int count=luoTieto.executeUpdate();
			temp =true;
			System.out.println(count);
		}catch(SQLException e) {
			do {
				System.out.println("Viesti: " + e.getMessage());
				System.out.println("Virhekoodi: " + e.getErrorCode());
				System.out.println("Viesti: " + e.getSQLState());
				}while(e.getNextException()!=null);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return temp;
	}

	@Override
	public Valuutta readValuutta(String tunnus) {
		Valuutta lue = null;
		try(PreparedStatement lueTieto= conn.prepareStatement("SELECT tunnus,vaihtkurssi,nimi FROM valuutat WHERE tunnus = ?"))
		{
			lueTieto.setString(1, tunnus);
			ResultSet rs=lueTieto.executeQuery();
			while(rs.next()) {
				String tunnus1=rs.getString("tunnus");
				String nimi=rs.getString("nimi");
				double vaihtokrs=rs.getDouble("vaihtkurssi");
				lue=new Valuutta(tunnus1,vaihtokrs,nimi);
			}
		} catch (SQLException e) {
			do {
				System.out.println("Viesti: " + e.getMessage());
				System.out.println("Virhekoodi: " + e.getErrorCode());
				System.out.println("Viesti: " + e.getSQLState());
				e.printStackTrace();
			}while(e.getNextException()!=null);
		
		}
		return lue;
	}

	@Override
	public Valuutta[] readValuutat() {
		ArrayList<Valuutta> lista=new ArrayList();
		ResultSet rs=null;
		Statement stmt=null;
		try {
			 stmt =conn.createStatement();
			String query="SELECT tunnus,vaihtkurssi,nimi FROM valuutat";
			
			 rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				
			String tunnus=rs.getString("tunnus");
			String nimi=rs.getString("nimi");
			double vaihtokrs=rs.getDouble("vaihtkurssi");
			
			lista.add( new Valuutta(tunnus,vaihtokrs,nimi));
				
			}
		} catch (SQLException e) {
			do {
				System.out.println("Viesti: " + e.getMessage());
				System.out.println("Virhekoodi: " + e.getErrorCode());
				System.out.println("Viesti: " + e.getSQLState());
				
			
		}while(e.getNextException()!=null);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			} catch(Exception e) {
				System.out.println("Resurssien vapautuksessa virhe");
			}
		}
		
		valuutat=new Valuutta[lista.size()];
		for(int i=0;i<lista.size();i++) {
			valuutat[i]=lista.get(i);
		}
		return valuutat;
		
	}

	@Override
	public boolean updateValuutta(Valuutta valuutta) {
		boolean temp=false;
		try(PreparedStatement paivitaTieto= conn.prepareStatement("UPDATE valuutat SET nimi=?,vaihtkurssi=? WHERE tunnus=?"))
		{
			paivitaTieto.setString(1, valuutta.getNimi());
			paivitaTieto.setDouble(2, valuutta.getVaihtokurssi());
			paivitaTieto.setString(3, valuutta.getTunnus());
			int count=paivitaTieto.executeUpdate();
			if(count>0) {
			temp =true;
			}
		
		}catch(SQLException e) {
			do {
				System.out.println("Viesti: " + e.getMessage());
				System.out.println("Virhekoodi: " + e.getErrorCode());
				System.out.println("Viesti: " + e.getSQLState());
				}while(e.getNextException()!=null);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return temp;
	
	}

	@Override
	public boolean deleteValuutta(String tunnus) {
		boolean temp=false;
		try(PreparedStatement poistaTieto= conn.prepareStatement("DELETE FROM valuutat WHERE tunnus=?"))
		{
			poistaTieto.setString(1,tunnus);
			int count=poistaTieto.executeUpdate();
			if(count>0) {
			temp=true;
			System.out.println("Poistettu "+count+" tietue tietokannasta");
			}
		}catch(SQLException e) {
			do {
				System.out.println("Viesti: " + e.getMessage());
				System.out.println("Virhekoodi: " + e.getErrorCode());
				System.out.println("Viesti: " + e.getSQLState());
				}while(e.getNextException()!=null);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return temp;
	
	}

}
