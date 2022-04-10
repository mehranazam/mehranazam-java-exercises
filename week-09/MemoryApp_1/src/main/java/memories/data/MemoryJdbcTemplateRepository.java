package memories.data;

import memories.models.Memory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class MemoryJdbcTemplateRepository implements MemoryRepository{

    private final JdbcTemplate jdbcTemplate;

    public MemoryJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Memory> mapper = (resultSet, rowNum) -> {
        Memory memory = new Memory();
        memory.setId(resultSet.getInt("memory_id"));
        memory.setFrom(resultSet.getString("`from`"));
        memory.setContent(resultSet.getString("content"));
        memory.setShareable(resultSet.getBoolean("isShareable"));
        return memory;
    };

    @Override
    public Memory add(Memory memory) throws DataAccessException {
        final String sql = "insert into memory (`from`, content, isShareable) values " +
                "(?, ?, ?), " +
                "(?, ?, ?), " +
                "(?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, memory.getFrom());
            ps.setString(2, memory.getContent());
            ps.setBoolean(3, memory.isShareable());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        memory.setId(keyHolder.getKey().intValue());
        return memory;
    }

    @Override
    public List<Memory> findAll() throws DataAccessException {
        final String sql = "select memory_id, `from`, content, isShareable from `memory`;";
        return jdbcTemplate.query(sql, new MemoryMapper());
    }

    @Override
    public Memory findById(int id) throws DataAccessException {
        final String sql = "select memory_id, `from`, content, isShareable from memory where memory_id = id;";
        try {
            // 2. Parameters always follow SQL and mappers.
            // Any number of parameters is allowed.
            return jdbcTemplate.queryForObject(sql, mapper, id);
        } catch (EmptyResultDataAccessException ex) {
            // 3. queryForObject can throw an unchecked exception
            // If the ResultSet is empty, it just means the pet with the id wasn't found.
            // So returning null is valid.
            return null;
        }
    }

    @Override
    public List<Memory> findBySender(String sender) throws DataAccessException {
        return null;
    }

    @Override
    public boolean update(Memory memory) throws DataAccessException {
        final String sql = "update memory set "
                + "`from` = ?, "
                + "content = ?, "
                + "isShareable = ?;";
        int rowsUpdated = jdbcTemplate.update(sql,
                memory.getFrom(), memory.getContent(), memory.isShareable());
        return rowsUpdated > 0;
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
        final String sql = "delete from memory where memory_id = ?;";
        return jdbcTemplate.update(sql, i) > 0;
    }
}
