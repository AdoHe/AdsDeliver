DROP FUNCTION IF EXISTS RAD;

delimiter //
CREATE FUNCTION RAD(d FLOAT) 
	RETURNS FLOAT 

BEGIN
	DECLARE pi FLOAT;
	SET pi = 3.141592625;
	RETURN d * pi / 180.0;
END;


DROP FUNCTION IF EXISTS GET_DISTANCE;
CREATE FUNCTION GET_DISTANCE(lng1 float,
		lat1 float,
		lng2 float,
		lat2 float)
		RETURNS float

BEGIN
	DECLARE earth_padius FLOAT;
	DECLARE radLat1 FLOAT;
	DECLARE radLat2 FLOAT; 
	DECLARE a FLOAT;
	DECLARE b FLOAT;
	DECLARE s FLOAT;
	SET earth_padius = 6378.137;

	SET radLat1 = RAD(lat1);
	SET radLat2 = RAD(lat2);

	SET a = radLat1 - radLat2;
	SET b = RAD(lng1) - RAD(lng2);
	SET s = 2 * ASIN(SQRT(POWER(SIN(a / 2), 2) + COS(radLat1) * cos(radLat2) * POWER(SIN(b / 2), 2)));
	SET s = s * earth_padius;
	SET s = ROUND(s * 1000) / 1000;

	RETURN s;
END; //

delimiter ;
