// Create a connection to http://localhost:9999/echo
var sock = new SockJS('http://localhost:8080/endpoint');

// Open the connection
sock.onopen = function() {
    console.log('open');
};

// On connection close
sock.onclose = function() {
    console.log('close');
};
sock.onmessage = function(e) {
    // Get the content
    var content = JSON.parse(e.data);

    // Append the text to text area (using jQuery)
    $('#chat-content').val(function(i, text){
        return e.data+ '\n' + text;
    });

};
function sendMessage(){
    // Get the content from the textbox
    var message = $('#message').val();
    var username = $('#username').val();

    // The object to send
    var send = {
        message: message,
        username: username
    };

    // Send it now
    sock.send(JSON.stringify(send));
}