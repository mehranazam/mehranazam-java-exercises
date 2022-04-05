import { useState, useEffect } from "react";
import AgentArticle from "./AgentArticle";

function AgentNews() {
  const [articles, setArticles] = useState([]);

  useEffect(() => {
    fetch("http://localhost:2000/news")
      .then((response) => {
        if (response.status === 200) {
          return response.json();
        }
      })
      .then((result) => setArticles(result))
      .catch((rejection) => console.log(rejection));
  }, []);

  fetch("http://localhost:2000/news")
    .then((response) => {
      console.log("Response: ", response);
      let promiseExample = response.json();
      console.log(promiseExample);
      return promiseExample;
    })
    .then((result) => {
      console.log("Result: ", result);
    });

  function articleFactory() {
    console.log(
      articles.map((article, index) => (
        <AgentArticle key={index} article={article} />
      ))
    );
  }

  // fetch(URL-FOR-NEWS-ARTICLES)

  return <>{articleFactory()}</>;
}

export default AgentNews;
