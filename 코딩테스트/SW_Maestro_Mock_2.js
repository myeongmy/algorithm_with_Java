function submit () {
	var arr = [];
	if(document.querySelector('#n1').checked === true){
		arr.push(document.querySelector('#n1').value);
	}
	if(document.querySelector('#n2').checked === true){
		arr.push(document.querySelector('#n2').value);
	}
	if(document.querySelector('#n3').checked === true){
		arr.push(document.querySelector('#n3').value);
	}
	if(document.querySelector('#n4').checked === true){
		arr.push(document.querySelector('#n4').value);
	}
	if(document.querySelector('#n5').checked === true){
		arr.push(document.querySelector('#n5').value);
	}
	
	fetch('/submit', {
		method: 'POST',
		headers: {'Content-Type': 'application/json'},
		body: JSON.stringify({ answers: arr})
	})
		.then(res => res.json())
		.then(ret => {
			// Update Element
			if(ret === true){
				document.querySelector('#result').innerHTML = '정답입니다.';
			}else{
				document.querySelector('#result').innerHTML = '오답입니다.';
			}
		});
};
