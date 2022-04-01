import { useState } from "react";
import Movie from "./Movie.js";

function Movies() {
  const [movies, setMovies] = useState([]);

  function clickHandler() {
    setMovies([
      { id: 1, title: "Toy Story", releaseYear: 1995 },
      { id: 2, title: "The Iron Giant", releaseYear: 1999 },
      { id: 3, title: "Spider-Man: Into the Spider-Verse", releaseYear: 2018 },
    ]);
  }

  const listMovies = () => {
    return movies.map((movie) => (
      <Movie
        key={movie.id}
        id={movie.id}
        title={movie.title}
        releaseYear={movie.releaseYear}
        deleteMovie={deleteMovie}
      />
    ));
  };

  function deleteMovie(id) {
    let editedMoviesArray = [...movies].filter((movie) => movie.id !== id);
    setMovies(editedMoviesArray);
  }

  return (
    <>
      <button onClick={clickHandler}>Click for Movies!</button>
      {listMovies()}
    </>
  );
}

export default Movies;
