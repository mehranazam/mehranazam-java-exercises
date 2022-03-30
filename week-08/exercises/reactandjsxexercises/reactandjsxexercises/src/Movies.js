import Movie from "./Movie.js";

function Movies() {
  const movies = [
    { id: 1, title: "Toy Story", releaseYear: 1995 },
    { id: 2, title: "The Iron Giant", releaseYear: 1999 },
    { id: 3, title: "Spider-Man: Into the Spider-Verse", releaseYear: 2018 },
  ];

  const listMovies = () => {
    let arr = movies.map((movie) => (
      <>
        <Movie title={movie.title} ry={movie.releaseYear} />
      </>
    ));

    return arr;
  };

  return <ol>{listMovies()}</ol>;
}

export default Movies;
