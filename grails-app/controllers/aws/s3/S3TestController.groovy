package aws.s3

class S3TestController {

    def uploadWithDefaultProperties = {
	
		def fileToUpload = "/Users/blanq01/Desktop/grails-aws/simpleUploadWithDefaultProperties.pdf"
		def uploadedFile = new File(fileToUpload).s3upload { }
		
		render uploadedFile.toString()
	}

    def uploadWithOtherBucket = {
	
		def fileToUpload = "/Users/blanq01/Desktop/grails-aws/simpleUploadWithDefaultProperties.pdf"
		def uploadedFile = new File(fileToUpload).s3upload {
			bucket "new-bucket-in-default-region"
		}
		
		render uploadedFile.toString()
	}
	
	def uploadWithOtherBucketInOtherRegion = {
	
		def fileToUpload = "/Users/blanq01/Desktop/grails-aws/simpleUploadWithDefaultProperties.pdf"
		def uploadedFile = new File(fileToUpload).s3upload {
			bucket "bucket-in-eu-region", "EU"
		}
		
		render uploadedFile.toString()
	}
	
	def uploadWithPath = {
	
		def fileToUpload = "/Users/blanq01/Desktop/grails-aws/simpleUploadWithDefaultProperties.pdf"
		def uploadedFile = new File(fileToUpload).s3upload { 
			path "path/created"
		}
		
		render uploadedFile.toString()
	}

	def uploadWithMetadata = {
	
		def fileToUpload = "/Users/blanq01/Desktop/grails-aws/simpleUploadWithMetadata.pdf"
		def uploadedFile = new File(fileToUpload).s3upload { 
			metadata param1: 'value1', param2: 'value2'
		}
		
		render uploadedFile.toString()
	}    

	def uploadWithRRS = {
	
		def fileToUpload = "/Users/blanq01/Desktop/grails-aws/simpleUploadWithRSS.pdf"
		def uploadedFile = new File(fileToUpload).s3upload { 
			rrs true
		}
		
		render uploadedFile.toString()
	}    
	
	def uploadPrivate = {
	
		def fileToUpload = "/Users/blanq01/Desktop/grails-aws/simpleUploadPrivate.pdf"
		def uploadedFile = new File(fileToUpload).s3upload { 
			acl "private"
		}
		
		render uploadedFile.toString()
	}    
}