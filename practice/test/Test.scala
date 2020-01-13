import java.util.Date

object Test{
  def main(args: Array[String]){
    var date = "%tF %<tT" format new Date
    val new_post = new Post("111", "ABC", "hello", "", 0, date)

    printf("%s \n", new_post.posted_at)
    printf("id: %s\n
      user_id: %s\n
      text: %s\n
      parent_post_id: %s\n
      comment_count: %d\n
      posted_at: %s\n",new_post.id, new_post.user_id, new_post.text, new_post.parent_post_id, new_post.comment_count, new_post.posted_at)
  }

  class Post(var id: String,
    var user_id: String,
    var text: String,
    var parent_post_id: String,
    var comment_count: Int,
    var posted_at: String
   ){
  }
}

// jsonを表示するにはどうすればいいのかを考える。
// curlした画面に返すから、普通のprintではダメ。
