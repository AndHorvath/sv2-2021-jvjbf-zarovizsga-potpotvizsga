package settlers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Objects;

public class SettlerRepository {

    // --- attributes ---------------------------------------------------------

    private JdbcTemplate jdbcTemplate;

    // --- constructors -------------------------------------------------------

    public SettlerRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // --- getters and setters ------------------------------------------------

    public JdbcTemplate getJdbcTemplate() { return jdbcTemplate; }

    // --- public methods -----------------------------------------------------

    //language=SQL
    public long saveNewSettler(Settler settler) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> getPreparedStatement(connection, settler), keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    //language=SQL
    public Settler findSettlerById(long id) {
        return jdbcTemplate.queryForObject(
            "select * from settlers where id = ?",
            (resultSet, rowNumber) -> createSettlerFromResult(resultSet, id),
            id
        );
    }

    //language=SQL
    public void updateGrowthAndIncome(long id, int amount) {
        jdbcTemplate.update(
            "update settlers " +
            "set amount_of_tobacco = amount_of_tobacco - ?, expected_income = expected_income - ? " +
            "where id = ?",
            amount, getChangeInIncome(amount), id
        );
    }

    // --- private methods ----------------------------------------------------

    private PreparedStatement getPreparedStatement(Connection connection, Settler settler) throws SQLException {
        PreparedStatement preparedStatement = createPreparedStatementForSave(connection);
        parametrizePreparedStatement(preparedStatement, settler);
        return preparedStatement;
    }

    //language=SQL
    private PreparedStatement createPreparedStatementForSave(Connection connection) throws SQLException {
        return connection.prepareStatement(
            "insert into settlers (name_of_settler, amount_of_tobacco, expected_income) values (?, ?, ?)",
            Statement.RETURN_GENERATED_KEYS
        );
    }

    private void parametrizePreparedStatement(
        PreparedStatement preparedStatement, Settler settler) throws SQLException {

        preparedStatement.setString(1, settler.getNameOfSettler());
        preparedStatement.setInt(2, settler.getAmountOfTobacco());
        preparedStatement.setInt(3, settler.getExpectedIncome());
    }

    private Settler createSettlerFromResult(ResultSet resultSet, long id) throws SQLException {
        Settler settler = new Settler(
            resultSet.getString("name_of_settler"),
            resultSet.getInt("amount_of_tobacco")
        );
        settler.setId(id);
        return settler;
    }

    private int getChangeInIncome(int amount) {
        return Settler.UNIT_PRICE * amount;
    }
}