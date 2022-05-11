var startAnimation = (theElement, classList) => {
	classList.split(' ').forEach(function(cssClass) {
	    if (theElement) {
	    	theElement.classList.add(cssClass);
	    } 
	});
}

var startTextAnimation = (theElement, classList) => {
	startAnimation(theElement, classList);
	var letter = theElement.innerHTML;
    letter = letter.trim();
    var str = '';
    var delay = 100;
    for (l = 0; l < letter.length; l++) {
        if (letter[l] != ' ') {
            str += '<span style="animation-delay:' + delay + 'ms; -moz-animation-delay:' + delay + 'ms; -webkit-animation-delay:' + delay + 'ms; ">' + letter[l] + '</span>';
            delay += 150;
        } else
            str += letter[l];
    }
    theElement.innerHTML = str;
}

var clearAnimation = (theElement, classList) => {
	classList.split(' ').forEach(function(cssClass) {
		if (theElement) {
			theElement.classList.remove(cssClass);
		} 
	});
}

var clearTextAnimation = (theElement, classList) => {
	clearAnimation(theElement, classList);
	theElement.innerHTML = theElement.textContent;
}

var updateAnimation = (theElement, oldValue, newValue) => {
	if (oldValue) {
		theElement.classList.remove(oldValue);
	} 
	if (newValue) {
		theElement.classList.add(newValue);
	}
}

var backToNormal = (theElement, oldValue, newValue) => {
	updateAnimation(theElement, oldValue, newValue);	
}