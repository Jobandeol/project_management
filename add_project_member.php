 <?php

$data = file_get_contents('php://input');

$decoded_data = json_decode($data , true );



$email = $decoded_data['email_key'];

$project_id = $decoded_data['project_id'];

$connection = mysqli_connect('localhost' , 'root' , '');

mysqli_select_db($connection , 'project_mangement');

$result = mysqli_query($connection , "insert into project_members (member_email , project_id) values ('$email' , '$project_id')");



if($result)
	
	{
	
		$response['key'] = "done";
		
		
		echo json_encode($response);
	}
	
	else {
		$response['key'] = "not done";
		
		echo json_encode($response);
		
	}

?>