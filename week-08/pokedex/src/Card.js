function Card(props) {
  return (
    <div class="card">
      <h2>
        {props.singlePk.num}: {props.singlePk.name}
      </h2>
      <img src={props.singlePk.img} />
      <button onClick={() => props.deletePokemon(props.singlePk.id)}>X</button>
    </div>
  );
}

export default Card;
