const Movie = (props) => {
  return (
    <ul className="inline-list">
      <li>
        <h4>{props.title}</h4>
        <p>{props.releaseYear}</p>
      </li>

      <button onClick={() => props.deleteMovie(props.id)}>X</button>
    </ul>
  );
};

export default Movie;
