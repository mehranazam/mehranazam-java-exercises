package learn.data;

import learn.models.Instructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstructorFileRepoTest {


    String seedDirectory = "./university-mastery-data-seed";
    String testDirectory = "./university-mastery-data-test";

    InstructorRepo toTest = new InstructorFileRepo(Paths.get(testDirectory,"instructors.csv").toString());


    @BeforeEach
    public void setup() throws IOException {
        //1. delete everything under the test folder
        clearDirectory(testDirectory);


        //2. copy everything from seed to test
        copyAllFiles(seedDirectory, testDirectory);


    }

    private void clearDirectory( String dir ){
        //1.1 Create a File object for our folder
        File testDir = new File(dir);

        //1.2 Get each "File" under that folder
        File[] filesUnderTestDir = testDir.listFiles();

        //1.3 Loop through each "File"
        for( File toDelete : filesUnderTestDir ) {
            if( toDelete.isFile() ){
                //1.4   if it's REALLY a file, delete it
                toDelete.delete();
            } else {
                //1.5   if it's a folder, repeat this process on that folder
                //recursively clear the directory
                clearDirectory( toDelete.getAbsolutePath() );

                //todo: delete the directory itself
            }
        }
    }

    private void copyAllFiles(String fromDir, String toDir) throws IOException {
        File seedDir = new File(fromDir);

        //2.1 get all files/folders
        File[] seedFiles = seedDir.listFiles();

        for( File toCopy : seedFiles ){

            //2.2 generate the "to" path
            Path newPath = Paths.get(toDir, toCopy.getName());

            if( toCopy.isFile() ){
                //if it really is a file, copy it
                Files.copy( toCopy.toPath(), newPath, StandardCopyOption.REPLACE_EXISTING);
            } else {
                //if it's a directory, recursively repeat this process on the files
                //under that directory
                copyAllFiles( toCopy.getAbsolutePath(), newPath.toString() );
            }
        }
    }


    @Test
    void shouldGetOneInstructorsByFullLastName() throws DataException {

        List<Instructor> matching = toTest.getInstructorsByLastName("Stanton");

        assertEquals(1, matching.size());

        assertEquals("68C594E3-83A0-EACD-C681-576994EB041E", matching.get(0).getId());
        assertEquals("Stanton", matching.get(0).getLastName());
        assertEquals( "Sylvester", matching.get(0).getFirstName());
    }

    @Test
    void shouldGetThreeInstructorsByPartialLastName() throws DataException {

        List<Instructor> matching = toTest.getInstructorsByLastName("Ga");

        assertEquals(3, matching.size());
        //TODO: consider data asserts
    }
}