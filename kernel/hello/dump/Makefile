obj-m := hello.o
KERNELBUILD := /lib/modules/$(shell uname -r)/build
default:
	make -C $(KERNELBUILD) M=$(shell pwd) modules
clean:
	rm -rf hello.ko hello.mod.c hello.mod.o hello.o modules.order Module.symvers  .hello.ko.cmd .hello.mod.o.cmd .hello.o.cmd .tmp_versions 
