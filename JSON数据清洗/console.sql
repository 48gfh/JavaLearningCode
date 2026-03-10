CREATE EXTERNAL TABLE IF NOT EXISTS product_reviews (
    reviewerID STRING,
    productID STRING,
    rating FLOAT,
    reviewDate STRING,
    summary STRING,
    reviewText STRING,
    recommend STRING,
    reviewerName STRING,
    useful INT
)
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
WITH SERDEPROPERTIES (
    "field.delim" = ",",
    "line.delim" = "\n",
    "serialization.format" = ","
)
LOCATION '/output/cleaned';

set hive.exec.mode.local.auto=false;
set mapreduce.framework.name=yarn;


-- 创建resultData用于存储计算好的数据
create database result;

-- 评分分布
create table result.score as
select
    rating,
    count(*) as count
    from product_reviews
group by rating;

-- 用户行为分析

create table result.dataAnalyes as
SELECT
  COUNT(CASE WHEN reviewText LIKE '%return%' THEN 1 END) as Return_Count,
  COUNT(CASE WHEN reviewText LIKE '%exchange%' THEN 1 END) as Exchange_Count
FROM
  product_reviews;


-- 产品评分与推荐相关性

create table result.ProductRatingrecommendation as
SELECT
  rating,
  COUNT(CASE WHEN recommend = 'yes' THEN 1 END) as Recommended_Count,
  COUNT(*) as Total_Count,
  COUNT(CASE WHEN recommend = 'yes' THEN 1 END) / COUNT(*) as Recommendation_Rate
FROM
  product_reviews
GROUP BY
  rating;

-- 将数据迁移到HDFS中
export table result.dataAnalyes to '/resultData';
export table result.score to '/resultData';
export table result.productratingrecommendation to '/resultData'