package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constants.MessageJavaLar;
import union.EventsJavaLar;

public class DataSelect {
	private Connection connection;
	private EventsJavaLar eventsJavaLar;

	public DataSelect(EventsJavaLar eventsJavaLar) {
		this.eventsJavaLar = eventsJavaLar;
	}

	public void openConnection() {
		DataBaseConnection database = new DataBaseConnection();
		setConnection(database.getConnection());
	}

	public List<List<Object>> retrieveData() {
		List<List<Object>> data = new ArrayList<>();

		Boolean verifyInitProcessDatabase = false;

		String[] columns = {
				"nome",
				"matricula",
				"nome_arquivo",
				"bug_python",
				"bug_javascript",
				"bug_ruby",
				"bug_php",
				"bug_csharp",
				"bug_cmais",
				"bug_c",
				"dev_python",
				"dev_javascript",
				"dev_ruby",
				"dev_php",
				"dev_csharp",
				"dev_cmais",
				"dev_c",
				"v_python",
				"v_javascript",
				"v_ruby",
				"v_php",
				"v_csharp",
				"v_cmais",
				"v_c",
				"d_python",
				"d_javascript",
				"d_ruby",
				"d_php",
				"d_csharp",
				"d_cmais",
				"d_c",
				"a_python",
				"a_javascript",
				"a_ruby",
				"a_php",
				"a_csharp",
				"a_cmais",
				"a_c",
				"bug_q1",
				"bug_q2",
				"bug_q3",
				"bug_q4",
				"dev_q1",
				"dev_q2",
				"dev_q3",
				"dev_q4"
		};

		MessageJavaLar.READ_FILE_OTHERS_USERS.showMessage();
		openConnection();
		StringBuilder queryBuilder = new StringBuilder("SELECT ");
		for (int i = 0; i < columns.length; i++) {
			queryBuilder.append(columns[i]);
			if (i < columns.length - 1) {
				queryBuilder.append(", ");
			}
		}
		queryBuilder.append(" FROM javalar");
		String query = queryBuilder.toString();

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			ResultSet resultSet = statement.executeQuery();

			List<Object> headerRow = new ArrayList<>();
			for (String column : columns) {
				headerRow.add(column);
			}
			data.add(headerRow);

			while (resultSet.next()) {
				List<Object> rowData = new ArrayList<>();

				for (String column : columns) {
					rowData.add(resultSet.getObject(column));
				}

				data.add(rowData);
			}
			verifyInitProcessDatabase = true;
			MessageJavaLar.READ_FILE_OTHERS_USERS.showMessageSpecial(verifyInitProcessDatabase);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return data;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public EventsJavaLar getEventsJavaLar() {
		return eventsJavaLar;
	}
}
