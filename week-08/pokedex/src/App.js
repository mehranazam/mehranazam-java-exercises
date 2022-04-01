import Heading from "./Heading";
import Container from "./Container";
import Form from "./Form";
import List from "./List";
import pokedex from "./data";
import { useState } from "react";

function App() {
  const [pokemon, setPokemon] = useState([]);
  const [favoritePokemon, setFavoritePokemon] = useState([]);

  function buttonHandler() {
    setPokemon(pokedex.pokemon);
  }

  function deletePokemon(id) {
    let newPokemonArray = [...pokemon];
    setPokemon(newPokemonArray.filter((pokemon) => pokemon.id !== id));
  }

  function addToFavorites(pokedexNum, e) {
    e.preventDefault();
    let newPokemonArray = [...pokemon];
    let foundFavorite = newPokemonArray.filter(
      (pokemon) => pokemon.num === pokedexNum
    );
    let newFavoritePokemonArray = [...favoritePokemon, ...foundFavorite];
    setFavoritePokemon(newFavoritePokemonArray);
  }

  return (
    <div className="App">
      <Heading />
      <button onClick={buttonHandler}>Retrieve All Pokemon</button>
      <br />
      <br />
      <Form addToFavorites={addToFavorites} />
      <List favoritePokemon={favoritePokemon} />
      <Container pokemon={pokemon} deletePokemon={deletePokemon} />
    </div>
  );
}

export default App;
