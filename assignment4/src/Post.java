import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class Post {
    private int postID;
    private String postTitle;
    private String postBody;
    private String postType;
    private String postE;
    private String [] postTags;
    private String [] postTypes = {"Very Difficult", "Difficult", "Easy"};
    private String [] postEmergency = {"Immediately Needed", "Highly Needed", "Ordinary"};
    private ArrayList <String> postComments = new ArrayList<>();

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public void setPostTags(String[] postTags) {
        this.postTags = postTags;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public void setPostE(String postE) {
        this.postE = postE;
    }
    public boolean addPost() {
        if (isTitleValid(postTitle) && isBodyValid(postBody) && isTagValid(postTags) && isTypeValid(postType, postBody, postE)) {
            try (FileWriter writer = new FileWriter("post.txt", true)) {
                writer.write(toString() + "\n");
            }catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean isTitleValid(String title) {
        if (title.length() < 10 || title.length() > 250) {
            System.out.println("title failed");
            return false;
        }else{
            for (int i = 0; i < 5; i++) {
                if (!Character.isLetter(title.charAt(i))) {
                    System.out.println("title failed");
                    return false;
                }
            }
            return true;
        }
    }

    private boolean isBodyValid(String body) {
        if (body.length() >= 250) {
            return true;
        }else{
            System.out.println("body failed");
            return false;
        }
    }

    private boolean isTagValid(String[] tags) {
        if (tags.length < 2 || tags.length > 5) {
            System.out.println("tag failed");
            return false;
        }
        for (String tag: tags) {
            if (tag.length() < 2 || tag.length() > 10 || !tag.equals(tag.toLowerCase())) {
                System.out.println("tag failed");
                return false;
            }
        }
        return true;
    }

    private boolean isTypeValid(String type, String body, String emergency) {
        if(!Arrays.asList(postTypes).contains(type)) {
            System.out.println("Type failed");
            return false;
        }
        if(!Arrays.asList(postEmergency).contains(emergency)) {
            System.out.println("Emergency failed");
            return false;
        }
        if (type.equals("Easy") && (emergency.equals("Immediately Needed") || emergency.equals("Highly Needed"))) {
            System.out.println("Easy type failed");
            return false;
        }
        if ((type.equals("Very Difficult") || type.equals("Difficult")) && body.length() < 300) {
            System.out.println("Very Difficult && BoDy failed");
            return false;
        }
        if ((type.equals("Very Difficult") || type.equals("Difficult")) && emergency.equals("Ordinary")) {
            System.out.println("Very difficult failed");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PostID: " + postID + ", Title: " + postTitle + ", Body: " + postBody + ", Tags: " + Arrays.toString(postTags) + ", Types: " + postType + ", Emergency: " + postE + ".";
    }


    public boolean addComment(String comment) {
        if (isCommentValid(comment) && canBeAddComment(postComments.size())) {
            try (FileWriter writer = new FileWriter("comment.txt", true)) {
                writer.write(comment + "\n");
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            postComments.add(comment);
            return true;
        }

        return false;
    }

    private boolean isCommentValid(String comment) {
        String[] text = comment.split(" ");
        if (text.length < 4 || text.length > 10) {
            return false;
        }else {
            if (Character.isUpperCase(text[0].charAt(0))) {
                return true;
            }else {
                return false;
            }
        }
    }

    private boolean canBeAddComment(int numComments) {
        if (numComments >= 5) {
            return false;
        }else {
            return true;
        }
    }
}
