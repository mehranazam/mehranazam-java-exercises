package memories.data;

import memories.models.Memory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemoryMapper implements RowMapper<Memory> {


    @Override
    public Memory mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Memory memory = new Memory();
        memory.setId(resultSet.getInt("memory_id"));
        memory.setFrom(resultSet.getString("`from`"));
        memory.setContent(resultSet.getString("content"));
        memory.setShareable(resultSet.getBoolean("isShareable"));
        return memory;
    }

}
