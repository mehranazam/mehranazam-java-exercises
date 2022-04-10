//package memories.domain;
//
//import memories.data.DataAccessException;
//import memories.data.MemoryRepositoryDouble;
//import memories.models.Memory;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class MemoryServiceTest {
//
//    MemoryService service;
//
//    @BeforeEach
//    void setUp() {
//        MemoryRepositoryDouble repository = new MemoryRepositoryDouble();
//        service = new MemoryService(repository);
//    }
//
//    @Test
//    void shouldHaveTwoPublicMemories() throws DataAccessException {
//        List<Memory> memories = service.findPublicMemories();
//        assertEquals(2, memories.size());
//    }
//
//    //happy path
//    @Test
//    void shouldAddGoodMemory() throws DataAccessException {
//        //Arrange
//        //  set up our Memory object be added
//        Memory toAdd = new Memory();
//        toAdd.setFrom( "Bob" );
//        toAdd.setContent( "this is bob's memory");
//        toAdd.setShareable( true );
//
//        //Act
//        //  call the service add method
//        MemoryResult result = service.add(toAdd);
//
//        //Assert
//        // check the MemoryResult we get back
//        assertEquals( 0, result.getMessages().size() );
//        assertEquals( "Bob", result.getMemory().getFrom() );
//        assertEquals( "this is bob's memory", result.getMemory().getContent());
//        assertTrue( result.getMemory().isShareable() );
//
//
//        //maybe check getting the data we just added???
//        //skip for now
//        List<Memory> allPublicMemories = service.findPublicMemories();
//        Memory newlyAdded = null;
//        for( Memory toCheck : allPublicMemories ){
//            if( toCheck.getContent().equals("this is bob's memory") ){
//                newlyAdded = toCheck;
//            }
//        }
//
//        assertEquals( "Bob", newlyAdded.getFrom() );
//        assertTrue(newlyAdded.isShareable());
//
//    }
//
//    @Test
//    void shouldNotAddNullMemory() throws DataAccessException {
//        //Arrange
//        // create null memory
//        Memory toAdd = null;
//
//        //Act
//        //  call the service add method
//        MemoryResult result = service.add(toAdd);
//
//        //Assert
//        // check the MemoryResult we get back
//        assertEquals( 1, result.getMessages().size() );
//
//        assertEquals( "Memory cannot be null", result.getMessages().get(0));
//
//        assertNull( result.getMemory() );
//    }
//
//    @Test
//    void shouldUpdate() throws DataAccessException {
//        Memory memory = service.findPublicMemories().get(0);
//        memory.setContent("This is memory #0");
//        MemoryResult result = service.update(memory);
//        assertTrue(result.isSuccessful());
//    }
//
//    @Test
//    void shouldNotUpdate() throws DataAccessException {
//
//        Memory memory = new Memory();
//        memory.setId(66);
//        memory.setShareable(false);
//        memory.setFrom("Ro");
//        memory.setContent("This is content");
//        MemoryResult result = service.update(memory);
//        boolean success = result.isSuccessful();
//        assertFalse (success);
//    }
//}
