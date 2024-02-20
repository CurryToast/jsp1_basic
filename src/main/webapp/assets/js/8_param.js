document.getElementById('search').addEventListener('click', () => {
	const name = document.querySelector('#name').value;
	const age = document.querySelector('#age').value;
	let isValid = true;
	if (!name.length) {
		isValid = false;
	} else if (!age.length || isNaN(Number(age))) {
		isValid = false;
	}

	if (isValid) {
		location.href = `6_selectBy.jsp?name=${name}&age=${age}`;
	}
});