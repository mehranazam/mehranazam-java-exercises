package memories.data;

import com.mysql.cj.jdbc.MysqlDataSource;
import memories.models.Memory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MemoryJdbcRepository implements MemoryRepository{


    // 1. Dangerous initialization during construction
    private DataSource dataSource = initDataSource();

    private DataSource initDataSource() {
        MysqlDataSource result = new MysqlDataSource();
        // 2. connection string is:
        // [db-tech]:[db-vendor]://[host]:[port]/[database-name]
        result.setUrl("jdbc:mysql://localhost:3306/memories");
        // 3. username
        result.setUser("root");
        // 4. password
        result.setPassword("top-secret-password");
        return result;
    }

    @Override
    public Memory add(Memory memory) throws DataAccessException {
        final String sql = "insert into memory (`from`, content, isShareable) values (?, ?, ?);";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, memory.getFrom());
            statement.setString(2, memory.getContent());
            statement.setBoolean(3, memory.isShareable());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted <= 0) {
                return null;
            }

            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    memory.setId(keys.getInt(5));
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return memory;
    }

    @Override
    public List<Memory> findAll() throws DataAccessException {
        ArrayList<Memory> result = new ArrayList<>();
        final String sql = "select memory_id, `from`, content, isShareable from `memory`;";
        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                Memory memory = new Memory();
                memory.setId(rs.getInt("memory_id"));
                memory.setFrom(rs.getString("from"));
                memory.setContent(rs.getString("content"));
                memory.setShareable(rs.getBoolean("isShareable"));
                result.add(memory);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Memory findById(int id) throws DataAccessException {
        final String sql = "select memory_id, `from`, content, isShareable from `memory` where memory_id = id";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            // Replace the first '?' with petId.
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Memory memory = new Memory();
                    memory.setId(rs.getInt("memory_id"));
                    memory.setFrom(rs.getString("from"));
                    memory.setContent(rs.getString("content"));
                    memory.setShareable(rs.getBoolean("isShareable"));
                    return memory;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Memory> findBySender(String sender) throws DataAccessException {
        return null;
    }

    @Override
    public boolean update(Memory memory) throws DataAccessException {

        final String sql = "update memory set "
                + "`from` = Mark, "
                + "content = Fair Game, "
                + "isShareable = true "
                + "where memory_id = id;";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setString(1, memory.getFrom());
            statement.setString(2, memory.getContent());
            statement.setBoolean(3, memory.isShareable());
            statement.setInt(4, memory.getId());

            return statement.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Memory memory) throws DataAccessException {
        return false;
    }

    @Override
    public List<Memory> findShareable(boolean shareable) throws DataAccessException {
        return null;
    }

    @Override
    public boolean deleteById(int i) throws DataAccessException {
        final String sql = "delete from memory where memory_id = id;";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, i);
            return statement.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
