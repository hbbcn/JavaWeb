package com.alipay.config;

public class AlipayConfig {
	// 商户appid
	public static String APPID = "2021000119637477";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCQgw0LpKAm5WRuq8jTHIMCsWIRKX+S6NModR4fYBl9HJwQQEWEktBIUUQ/Zdzi1/k5Q33AXd+l0Qxga/oPcD7xn5Wk3YePy4XNu1OWkaRoq4vRplG5J8foXBuueWq7SuAfJ8CSHwH7nzy+p/DaxudT/0Fr1falMa+iplwz3VPpyHWps+6rKxHSvqlywEstQ7BcGh4cKM+lwhq1hPZZdaDcfICdj+cOHDPye4fY30/squdHe+RAhRtNlgcxcYTikePGuZxDlLIj8lnZWzqhbSHn043RsR0/f5tfpmU59XJP34jhvu7EAftfFCErPB2gaWjfy9k5CMZeZ+FxL6PdmjXbAgMBAAECggEAEBlZabOkV9D0WFPw4nvpqHIkb68E1FP1uisZ+PrWvBZk2Hagh/1nELdk9/8cFXVkAVogdz69/JYGX/OHfxLNIFPb8urvADj3Jg05aau9+h8qS2fQ8OSao6snNk+2cTkNMMtX669ipCqANOk2rti7yqLEIgRLHuojG+aWnPyKLaAI+M0TKF6bVly1wr8c3oMD4AA41ii52GIFbMh2a+fidFmWqEs89yhygvSk48VQD/bMmDReYeLI4jc8iqxLiLu6ujmwOddt2sBzpZrQOsMVNRag6P40HDwbBMHRb3bmlYwvB6gTDGrvMbJLuvvv+Z0o5Bgfjyo5oUf2tNMW7HtR2QKBgQDiHoKyDqU+k8KpS5pKOdgpmKexyTvX/ozds5B5ELshxouQ2yo4fzeIi1BmUIC66To7c0fbKOIYTELyAYmPCgZpfBilR6JBH7p6A+fOHHsZP/7kMM9+TW9x3iyfp22pzG8w0xUa8DRP5Sxk7Po45Dryj1gDtwaUMwXYD0cCJJIsRQKBgQCjm8+V+SJcGce3YTfmUMx2xhvAW7T4dK+VDzaKzkZ+PGeOiCj6Py3S8NK0rjIygoQKtgy+XNi8xcg9Mq6Nxp44eoLdQ48m2bXYHigl4YCsiYqbr7WTx6nfWdMJhBKHUHbhcUJCeJp0lFN4mHPuScOSAXQXc9m0YNWSazUvQT7LnwKBgBbkdeDnAK3MMdoH8G/xWUQk0115fRiKCeLsKgVHv1pVCo440hZ0MsAdMp+ZKN9De4THUBANHI7PMbvkkfOsVSfay3f4P6IOP0fZG1/PnFrbEsgxdOBZoJ3Lm4LyZXTaYKt1w1490V4BWrRBFbgqyxkBkCyYHA9m9wF/0nWSFEZtAoGAGLrKa87WhLlY2L0XJ/b6kNFtDGxQNGXezFcaVWzMdvRGauLl3r2B/aptDuZtq/jSYJQX5QY/tHjoxWdNvxxQehT6httZXfP2ao5UXzVwr6OykcnDVm0NnjcDkSKnclCVR4pJC6cTIZ/x5f6VN2Vq7DzQAWN/eqZQYetWhKgGB90CgYEA0tFBGu7Yby6WhLZgX4vIHwfe02xtfkHdq/fKJYsvgjJqBXt+b1F9eq4rsVVcBQlzkE4nTZZAT25novFPczro85bQd/LB82PhoYJfuTO7vkf7gS5iUsaCN+F6Q4yNl5JHXCV6yCxZHSOJTDpkqVV+eo15uQZVZ+QZgTLWmqsIk9M=";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	public static String return_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/return_url.jsp";
	// 请求网关地址
	public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjrEVFMOSiNJXaRNKicQuQdsREraftDA9Tua3WNZwcpeXeh8Wrt+V9JilLqSa7N7sVqwpvv8zWChgXhX/A96hEg97Oxe6GKUmzaZRNh0cZZ88vpkn5tlgL4mH/dhSr3Ip00kvM4rHq9PwuT4k7z1DpZAf1eghK8Q5BgxL88d0X07m9X96Ijd0yMkXArzD7jg+noqfbztEKoH3kPMRJC2w4ByVdweWUT2PwrlATpZZtYLmtDvUKG/sOkNAIKEMg3Rut1oKWpjyYanzDgS7Cg3awr1KPTl9rHCazk15aNYowmYtVabKwbGVToCAGK+qQ1gT3ELhkGnf3+h53fukNqRH+wIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
}
