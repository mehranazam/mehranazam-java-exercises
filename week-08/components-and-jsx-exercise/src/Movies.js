import { useState } from "react";

function Movies() {
    
    const [movies, setMovies] = useState([]);

    function clickHandler() {
        setMovies([
            { id: 1, title: 'Toy Story', releaseYear: 1995 },
            { id: 2, title: 'The Iron Giant', releaseYear: 1999 },
            { id: 3, title: 'Spider-Man: Into the Spider-Verse', releaseYear: 2018 },
        ]);
    }

    function renderMovies() {
        return movies.map(movie => (
            <div key={movie.id}>
                <h4>{movie.title}</h4>
                <p>{movie.releaseYear}</p>
            </div>
        ))
    }

    return (
        <>
            <button onClick={clickHandler}>Click for Movies!</button>
            {renderMovies()}
        </>
    )
}

export default Movies;