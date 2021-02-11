






sam.cmd init --location https://github.com/aws-samples/cookiecutter-aws-sam-s3-rekognition-dynamodb-python \
    --no-input

aws --profile myaccount s3 mb s3://myappmahla

sam.cmd package --profile myaccount \
    --template-file template.yaml \
    --output-template-file packaged.yaml \
    --s3-bucket myappmahla

sam.cmd deploy \
    --profile myaccount\
    --template-file packaged.yaml \
    --stack-name aws-sam-ocr \
    --capabilities CAPABILITY_IAM \
    --region eu-west-1



###test
TABLE_NAME=aws-sam-ocr-ResultsTable-RFCLK8HCRCL9 sam.cmd local invoke --profile myaccount --event SampleEvent.json

    table name : aws-sam-ocr-ResultsTable-RFCLK8HCRCL9
