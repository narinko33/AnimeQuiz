package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import model.Ranking;

public class RankingDAO extends DAO {
	//全件取得
	public List<Ranking> findAll() {
		List<Ranking> list = new ArrayList<Ranking>();
		try {
			this.connect();

			stmt = con.prepareStatement("SELECT * FROM ranking ORDER BY good DESC");
			rs = stmt.executeQuery();

			while (rs.next()) {
				//				レコードから各カラムのデータを取得
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int good = rs.getInt("good");
				String updated = rs.getString("updated");

				//				取得したデータでインスタンスを作成、リストに追加
				Ranking ranking = new Ranking(id, name, good, updated);
				list.add(ranking);
			}

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally {
			this.disconnect();
		}
		return list;
	}

	//	データ1件追加
	public void insertOne(Ranking ranking) {
		try {
			this.connect();

			stmt = con.prepareStatement("INSERT INTO ranking(name, good, updated) VALUES(?,?,?)");
			stmt.setString(1, ranking.getName());
			stmt.setInt(2, ranking.getGood());
			stmt.setString(3, ranking.getUpdated());
			stmt.execute();

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally {
			this.disconnect();
		}
	}
}
