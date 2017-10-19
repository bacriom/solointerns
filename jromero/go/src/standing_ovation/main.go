package main

import (
	"fmt"
	"io/ioutil"
)

func main() {
	t, err := ioutil.ReadFile("input.txt")
	if err != nil {
		fmt.Println(err)
	}

	fmt.Println(t)
  str := string(t[0])
  fmt.Println(str)
}
