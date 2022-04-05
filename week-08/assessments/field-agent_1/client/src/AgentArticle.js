function AgentArticle(props) {
  // props.article.headline
  // props.article.body
  // props.article.author

  const { headline, body, author } = props.article;

  return (
    <div className="article">
      <h3>
        {headline}
        <br />
        <sub>Written by: {author}</sub>
      </h3>
      <p>{body}</p>
    </div>
  );

  // headline, body, author
}

export default AgentArticle;
