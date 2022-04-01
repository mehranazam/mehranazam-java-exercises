function List(props) {
  function renderPokemonName() {
    return props.favoritePokemon.map((favorite) => <li>{favorite.name}</li>);
  }

  return <ul>{renderPokemonName()}</ul>;
}

export default List;
