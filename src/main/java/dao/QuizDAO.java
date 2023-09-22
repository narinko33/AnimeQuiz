package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import model.Quiz;

public class QuizDAO extends DAO {
	//全件取得
	public List<Quiz> findAll() {
		List<Quiz> list = new ArrayList<Quiz>();
		try {
			this.connect();

			stmt = con.prepareStatement("SELECT * FROM quiz");
			rs = stmt.executeQuery();

			while (rs.next()) {
				//				レコードから各カラムのデータを取得
				int id = rs.getInt("id");
				String text = rs.getString("text");
				String answer = rs.getString("answer");

				//				取得したデータでインスタンスを作成、リストに追加
				Quiz quiz = new Quiz(id, text, answer);
				list.add(quiz);
			}

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally {
			this.disconnect();
		}
		return list;
	}

	//	データ1件追加
	public void insertOne(Quiz quiz) {
		try {
			this.connect();

			stmt = con.prepareStatement("INSERT INTO quiz(text,answer) VALUES(?,?)");
			stmt.setString(1, quiz.getText());
			stmt.setString(2, quiz.getAnswer());
			stmt.execute();

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} finally {
			this.disconnect();
		}
	}
	//ランダムに10件取得
		public List<Quiz> getRandom() {
			List<Quiz> list = new ArrayList<Quiz>();
			try {
				this.connect();

				stmt = con.prepareStatement("SELECT * FROM quiz ORDER BY RAND() LIMIT 10");
				rs = stmt.executeQuery();

				while (rs.next()) {
					//				レコードから各カラムのデータを取得
					int id = rs.getInt("id");
					String text = rs.getString("text");
					String answer = rs.getString("answer");

					//				取得したデータでインスタンスを作成、リストに追加
					Quiz quiz = new Quiz(id, text, answer);
					list.add(quiz);
				}

			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			} finally {
				this.disconnect();
			}
			return list;
		}
}
