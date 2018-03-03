SOC_FAMILY = "msm8974"

require conf/machine/include/soc-family.inc
require conf/machine/include/arm/arch-armv7a.inc

KERNEL_IMAGETYPE = "Image"

SERIAL_CONSOLE = "115200;ttyHSL0"

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS += " \
  kernel-modules \
  "

EXTRA_IMAGECMD_ext4 += " -b 4096 "

MACHINE_FEATURES = " \
  usbhost \
  usbgadget \
  alsa \
  screen \
  wifi \
  bluetooth \
  ext2 \
  "

PREFERRED_PROVIDER_u-boot ?= "u-boot"
PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot"
PREFERRED_PROVIDER_virtual/kernel ?= "linux-sony-los"

KERNEL_CMDLINE = "vmalloc=300M console=ttyHSL0,115200,n8 root=/dev/sda65 rootwait"
KERNEL_RAMBASE = "0x00000000"
KERNEL_PAGESIZE = "2048"
RAMDISK_OFFSET = "0x02000000"
TAGS_OFFSET = "0x01E00000"
