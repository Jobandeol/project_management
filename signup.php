<?php

$data = file_get_contents('php://input');

$decoded_data = json_decode($data , true );

$email = $decoded_data['email_key'];
$password = $decoded_data['pass_key'];

$connection = mysqli_connect('localhost' , 'root' , '');

mysqli_select_db($connection , 'project_mangement');

$result = mysqli_query($connection , "insert into user_table (Email , Password ) values ('$email' , '$password' ) ");

if($result)
	
	{
		$response['response_key'] = "done";
		
		echo json_encode($response);
	}
	
	else {
		$response['response_key'] = "not done";
		
		echo json_encode($response);
		
	}

?>