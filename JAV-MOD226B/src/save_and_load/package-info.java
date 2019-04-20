/**
 *  This package is for learning about different save and load variants in Java
 *  
 *  The ultimate goal: able to save a current state in a Java Application and get it back.
 *  
 *  NOTE: Since I abandoned this package to proceed with other stuff revert open tasks
 *  from *** to TODO again via search > file search and replace.
 *  
 *  The steps to this are, learn to:
 *  DONE 1. Serialize an Object @see Write_and_read_to_ObjectStream_aClass
 *  DONE do PathTest_8_17 from the book! cause stuck with rest!!
 *  aka mostly done, revisit only for open question on toRealPath()
 *  DONE do 8.19 partially for create file -> CreateFile_8_19.java
 *  DONE Learn how to use Path to set it to the current working dir! -> PathGetPathExample.java file
 *  DONE create a file, use it, then delete it -> CreateFileTmpUseDel.java
 *  DONE **learn to use DELETE_ON_CLOSE -> CreateFileDelOnClose.java**
 *  DONE test: deleteIfExists -> CreateFileDelIfExists.java
 *  DONE test: void java.io.File.deleteOnExit() -> TestDeleteOnExit.java
 *      NOTE: this is using the old Java io.File API!
 *  ***, FIXME ** Write what you learned into java.md **
 *  DONE insert delete to all other examples where a file is created! Clean up the mess. =), aka DELETE_ON_CLOSE for nio?, 
 *  *** do 8.18 from book for Directory operations, find files etc.
 *  *** describe gained knowledge to java.md
 *  *** 2. write Object to a file see: Methods for Unbuffered Streams and Interoperable with java.io APIs -> use CreateFileTest2.java
 *  *** 3. read from file
 *  DONE 4. insert data back to object @see Write_and_read_to_ObjectStream_aClass
 *  
 *  *** clean up CreateFileTestSoloLearn.java
 *  *** learn how to set a Link in .java Comment that opens to the website?
 *  
 *  Resources: 
 *  @see https://docs.oracle.com/en/java/javase/11/docs/specs/serialization/serial-arch.html#accessing-serializable-fields-of-a-class
 *  @see https://docs.oracle.com/javase/tutorial/essential/io/fileio.html
 *  @see https://github.com/EsotericSoftware/jsonbeans 
 */
/**
 * @author vinma
 *
 */
package save_and_load;