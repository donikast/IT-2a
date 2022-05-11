function editProfileInfo() {
  debugger
  const formData = toJSONString(document.querySelector('form.edit-info'));

  fetch('userInfo', { 
	  method: 'POST',
	  headers: {
		  'Content-Type': 'application/json', 'Accept': 'application/json'
		  },
	  body: formData
  })
  .then((response) => {
    return response.json();
  })
  .then((data) => {
	var element = document.getElementById('sussess-info');
	element.innerHTML = data.message;
    console.log(data);
    console.log(data.userBean);
  });
  
  return false;
}

function toJSONString(form) {
	let obj = {};
	let elements = form.querySelectorAll( "input, textarea" );
	for(let i = 0; i < elements.length; ++i ) {
		let element = elements[i];
		let name = element.name;
		let value = element.value;

		if(name) {
			obj[name] = value;
		}
	}

	return JSON.stringify(obj);
}

