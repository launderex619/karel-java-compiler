	.file	"code.cpp"
# GNU C++14 (Ubuntu 7.4.0-1ubuntu1~18.04) version 7.4.0 (x86_64-linux-gnu)
#	compiled by GNU C version 7.4.0, GMP version 6.1.2, MPFR version 4.0.1, MPC version 1.1.0, isl version isl-0.19-GMP

# GGC heuristics: --param ggc-min-expand=100 --param ggc-min-heapsize=131072
# options passed:  -fpreprocessed code.ii -mtune=generic -march=x86-64
# -fverbose-asm -fstack-protector-strong -Wformat -Wformat-security
# options enabled:  -fPIC -fPIE -faggressive-loop-optimizations
# -fasynchronous-unwind-tables -fauto-inc-dec -fchkp-check-incomplete-type
# -fchkp-check-read -fchkp-check-write -fchkp-instrument-calls
# -fchkp-narrow-bounds -fchkp-optimize -fchkp-store-bounds
# -fchkp-use-static-bounds -fchkp-use-static-const-bounds
# -fchkp-use-wrappers -fcommon -fdelete-null-pointer-checks
# -fdwarf2-cfi-asm -fearly-inlining -feliminate-unused-debug-types
# -fexceptions -ffp-int-builtin-inexact -ffunction-cse -fgcse-lm
# -fgnu-runtime -fgnu-unique -fident -finline-atomics -fira-hoist-pressure
# -fira-share-save-slots -fira-share-spill-slots -fivopts
# -fkeep-static-consts -fleading-underscore -flifetime-dse
# -flto-odr-type-merging -fmath-errno -fmerge-debug-strings -fpeephole
# -fplt -fprefetch-loop-arrays -freg-struct-return
# -fsched-critical-path-heuristic -fsched-dep-count-heuristic
# -fsched-group-heuristic -fsched-interblock -fsched-last-insn-heuristic
# -fsched-rank-heuristic -fsched-spec -fsched-spec-insn-heuristic
# -fsched-stalled-insns-dep -fschedule-fusion -fsemantic-interposition
# -fshow-column -fshrink-wrap-separate -fsigned-zeros
# -fsplit-ivs-in-unroller -fssa-backprop -fstack-protector-strong
# -fstdarg-opt -fstrict-volatile-bitfields -fsync-libcalls -ftrapping-math
# -ftree-cselim -ftree-forwprop -ftree-loop-if-convert -ftree-loop-im
# -ftree-loop-ivcanon -ftree-loop-optimize -ftree-parallelize-loops=
# -ftree-phiprop -ftree-reassoc -ftree-scev-cprop -funit-at-a-time
# -funwind-tables -fverbose-asm -fzero-initialized-in-bss
# -m128bit-long-double -m64 -m80387 -malign-stringops
# -mavx256-split-unaligned-load -mavx256-split-unaligned-store
# -mfancy-math-387 -mfp-ret-in-387 -mfxsr -mglibc -mieee-fp
# -mlong-double-80 -mmmx -mno-sse4 -mpush-args -mred-zone -msse -msse2
# -mstv -mtls-direct-seg-refs -mvzeroupper

	.text
	.section	.rodata
	.type	_ZStL19piecewise_construct, @object
	.size	_ZStL19piecewise_construct, 1
_ZStL19piecewise_construct:
	.zero	1
	.local	_ZStL8__ioinit
	.comm	_ZStL8__ioinit,1,1
	.text
	.globl	main
	.type	main, @function
main:
.LFB1493:
	.cfi_startproc
	pushq	%rbp	#
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp	#,
	.cfi_def_cfa_register 6
# code.cpp:3:    int posicionX = 0;
	movl	$0, -8(%rbp)	#, posicionX
# code.cpp:4:    int posicionY = 0;
	movl	$0, -28(%rbp)	#, posicionY
# code.cpp:5:    int mirada = 0;
	movl	$0, -4(%rbp)	#, mirada
# code.cpp:6:    int mochila = 0;
	movl	$0, -24(%rbp)	#, mochila
# code.cpp:7: 	mirada = (++mirada % 4);
	addl	$1, -4(%rbp)	#, mirada
	movl	-4(%rbp), %eax	# mirada, tmp90
	cltd
	shrl	$30, %edx	#, tmp92
	addl	%edx, %eax	# tmp92, tmp93
	andl	$3, %eax	#, tmp94
	subl	%edx, %eax	# tmp92, tmp95
	movl	%eax, -4(%rbp)	# tmp95, mirada
# code.cpp:8: 	for(int i = 0; i < 0; i++) {
	movl	$0, -20(%rbp)	#, i
.L5:
# code.cpp:8: 	for(int i = 0; i < 0; i++) {
	cmpl	$0, -20(%rbp)	#, i
	jns	.L2	#,
# code.cpp:9: 	for(int i = 0; i < 15; i++) {
	movl	$0, -16(%rbp)	#, i
.L4:
# code.cpp:9: 	for(int i = 0; i < 15; i++) {
	cmpl	$14, -16(%rbp)	#, i
	jg	.L9	#,
# code.cpp:10: 	posicionY++;
	addl	$1, -28(%rbp)	#, posicionY
# code.cpp:9: 	for(int i = 0; i < 15; i++) {
	addl	$1, -16(%rbp)	#, i
	jmp	.L4	#
.L9:
# code.cpp:16: 	mochila++;
	addl	$1, -24(%rbp)	#, mochila
# code.cpp:18: 	mochila++;
	addl	$1, -24(%rbp)	#, mochila
# code.cpp:8: 	for(int i = 0; i < 0; i++) {
	addl	$1, -20(%rbp)	#, i
	jmp	.L5	#
.L2:
# code.cpp:22: 	posicionY++;
	addl	$1, -28(%rbp)	#, posicionY
# code.cpp:23: 	for(int i = 0; i < 0; i++) {
	movl	$0, -12(%rbp)	#, i
.L7:
# code.cpp:23: 	for(int i = 0; i < 0; i++) {
	cmpl	$0, -12(%rbp)	#, i
	jns	.L6	#,
# code.cpp:24: 	posicionY++;
	addl	$1, -28(%rbp)	#, posicionY
# code.cpp:23: 	for(int i = 0; i < 0; i++) {
	addl	$1, -12(%rbp)	#, i
	jmp	.L7	#
.L6:
# code.cpp:26: 	return 0;
	movl	$0, %eax	#, _25
# code.cpp:27: }
	popq	%rbp	#
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1493:
	.size	main, .-main
	.type	_Z41__static_initialization_and_destruction_0ii, @function
_Z41__static_initialization_and_destruction_0ii:
.LFB1974:
	.cfi_startproc
	pushq	%rbp	#
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp	#,
	.cfi_def_cfa_register 6
	subq	$16, %rsp	#,
	movl	%edi, -4(%rbp)	# __initialize_p, __initialize_p
	movl	%esi, -8(%rbp)	# __priority, __priority
# code.cpp:27: }
	cmpl	$1, -4(%rbp)	#, __initialize_p
	jne	.L12	#,
# code.cpp:27: }
	cmpl	$65535, -8(%rbp)	#, __priority
	jne	.L12	#,
# /usr/include/c++/7/iostream:74:   static ios_base::Init __ioinit;
	leaq	_ZStL8__ioinit(%rip), %rdi	#,
	call	_ZNSt8ios_base4InitC1Ev@PLT	#
	leaq	__dso_handle(%rip), %rdx	#,
	leaq	_ZStL8__ioinit(%rip), %rsi	#,
	movq	_ZNSt8ios_base4InitD1Ev@GOTPCREL(%rip), %rax	#, tmp87
	movq	%rax, %rdi	# tmp87,
	call	__cxa_atexit@PLT	#
.L12:
# code.cpp:27: }
	nop
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1974:
	.size	_Z41__static_initialization_and_destruction_0ii, .-_Z41__static_initialization_and_destruction_0ii
	.type	_GLOBAL__sub_I_main, @function
_GLOBAL__sub_I_main:
.LFB1975:
	.cfi_startproc
	pushq	%rbp	#
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp	#,
	.cfi_def_cfa_register 6
# code.cpp:27: }
	movl	$65535, %esi	#,
	movl	$1, %edi	#,
	call	_Z41__static_initialization_and_destruction_0ii	#
	popq	%rbp	#
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1975:
	.size	_GLOBAL__sub_I_main, .-_GLOBAL__sub_I_main
	.section	.init_array,"aw"
	.align 8
	.quad	_GLOBAL__sub_I_main
	.hidden	__dso_handle
	.ident	"GCC: (Ubuntu 7.4.0-1ubuntu1~18.04) 7.4.0"
	.section	.note.GNU-stack,"",@progbits
