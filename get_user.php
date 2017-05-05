 <?php

$data = file_get_contents('php://input');

$decoded_data = json_decode($data , true );



$email = $decoded_data['email_key'];

$connection = mysqli_connect('localhost' , 'root' , '');

mysqli_select_db($connection , 'project_mangement');

$result = mysqli_query($connection , "Select * from user_table where Email = '$email' ");

$rows = mysqli_num_rows($result);

if($rows > 0)
	
	{
	$row = mysqli_fetch_assoc($result);
		
		$response['key'] = "done";
		$response['user'] = $row;
		
		echo json_encode($response);
	}
	
	else {
		$response['key'] = "not done";
		
		echo json_encode($response);
		
	}

?>