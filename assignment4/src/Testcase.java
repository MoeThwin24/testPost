import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class Testcase {
    private Post post;

    @BeforeEach
    void set() {
        post = new Post();
        post.setPostID(1);
        post.setPostTitle("Solve the algorithm");
        post.setPostBody("This is just a sample This is just a sampleThis is just a sampleThis is just a sampleThis is just a sampleThis is just a sampleThis is just a sampleThis is just a sampleThis is just a sampleThis is just a sample.This is just a sampleThis is just a sample");
        post.setPostTags(new String[]{"math", "calc"});
        post.setPostType("Easy");
        post.setPostE("Ordinary");
    }

    @Test
    void addPost_test_ValidPost() {
        assertTrue(post.addPost());
    }

    @Test
    void addPost_test_InvalidTitle() {
        post.setPostTitle("Title");
        assertFalse(post.addPost());
    }

    @Test
    void addPost_test_InvalidBody() {
        post.setPostBody("This question is x + y.");
        assertFalse(post.addPost());
    }

    @Test
    void addPost_test_invalidTags() {
        post.setPostTags(new String[]{"Tag1"});
        assertFalse(post.addPost());
    }

    @Test
    void addPost_test_InvalidTypeAndEmergency() {
        post.setPostType("Easy");
        post.setPostE("Highly Needed");
        assertFalse(post.addPost());
    }

    @Test
    void addPost_test_InvalidTypeWithInvalidBody() {
        post.setPostBody("This question is x + y.");
        post.setPostType("Very Difficult");
        post.setPostE("Ordinary");
        assertFalse(post.addPost());
    }

    @Test
    void addComment_test_validComment() {
        assertTrue(post.addComment("This is a testing comment."));
    }

    @Test
    void addComment_test_fewWords() {
        assertFalse(post.addComment("Hello"));
    }

    @Test
    void addComment_test_longWords() {
        assertFalse(post.addComment("This is a testing for long words, and it should be limiting as it is more than 10 words."));
    }

    @Test
    void addComment_test_lowerCase() {
        assertFalse(post.addComment("this comment starts with lowercase."));
    }

    @Test
    void addComment_test_MaxReached() {
        assertTrue(post.addComment("This is a comment."));
        assertTrue(post.addComment("This is a comment."));
        assertTrue(post.addComment("This is a comment."));
        assertTrue(post.addComment("This is a comment."));
        assertTrue(post.addComment("This is a comment."));
        assertFalse(post.addComment("This is a comment."));
    }

    @Test
    void addComment_test_MaxComments() {
        assertTrue(post.addComment("This is a comment."));
        assertTrue(post.addComment("This is a comment."));
        assertTrue(post.addComment("This is a comment."));
        assertTrue(post.addComment("This is a comment."));
        assertTrue(post.addComment("This is a comment."));
    }

}
