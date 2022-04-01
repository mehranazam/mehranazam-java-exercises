function Numbers(props) {

    function renderNumbersOneThroughTen() {
        let numArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
        return numArray.map(num => <li key={num}>{num}</li>);
    }

    function renderAnyRangeOfNumbers() {
        let numArray = [];
        for (let i = props.min; i <= props.max; i++) {
            numArray.push(<li key={i}>{i}</li>);
        }
        return numArray;
    }

    return (
        <ul>
            {renderNumbersOneThroughTen()}
            <br />
            {renderAnyRangeOfNumbers()}
        </ul>
    )
}

export default Numbers;