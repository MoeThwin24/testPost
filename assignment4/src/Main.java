
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Post post1 = new Post();
        post1.setPostID(1);
        post1.setPostTitle("Thiss is a valid post title");
        post1.setPostBody("This is just a sample This is just a sampleThis is just a sampleThis is just a sampleThis is just a sampleThis is just a sampleThis is just a sampleThis is just a sampleThis is just a sampleThis is just a sample.This is just a sampleThis is just a sample");
        post1.setPostTags(new String[]{"tag1", "tag2"});
        post1.setPostType("Easy");
        post1.setPostE("Ordinary");
        System.out.println(post1.addPost());
        System.out.println(post1.addComment("This is a simple comment for testing."));
    }
}

